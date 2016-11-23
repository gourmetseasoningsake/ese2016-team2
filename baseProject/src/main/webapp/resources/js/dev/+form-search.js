/**
 *
 * @name search
 * @memberof jQuery.flatfindr
 * @namespace jQuery.flatfindr.search
 */



jQuery.flatfindr.register({

  name: 'search',


  /**
   * @memberof jQuery.flatfindr.search
   * @method fn
   *
   * @protected
   * @param  {Object}   window   the window as you know it
   * @param  {Object}   document the document element
   * @param  {Object}   $        jQuery
   * @param  {jQuery}   $view    the default or custom view if set
   * @param  {Object}   option   what ever object param if passed
   * @return {Function}          method that sets up simple dom manipulations
   */
  fn: function (window, document, $, $view, option) {


    var
      /**
       * An opinionated bit of an extra delay. (usability specific)
       *
       * @private
       * @type {Number}
       * @constant
       */
      DURATION_BUFFER = 50,


      /**
       * The scrollable container.
       *
       * @type {Object}
       */
      $container_scroll = $('.form-search .container-scroll');





    /**
     * All input fields within the search form scrollable container.
     */
    $('.form-search .container-scroll input')
      .focus(alignInputToTop);



    /**
     * All checkboxes within the search form scrollable container.
     */
    $('.form-search .container-scroll label')
      .on('click', alignInputToTop);



    /**
     * The submit button.
     */
    $('[type=submit]').on('click', function () {
      validateType($('.form-search form')[0]);
    });



    /**
     * The clear button.
     */
    $('.form-search button[type=reset]')
      .on('click', alignTop);



    /**
     * Initiate datepicker with no date set.
     * @type {String}
     */
    $("#earliestMoveInDate").datepicker({
      altField: '#field-earliestMoveInDate',
      dateFormat : 'dd-mm-yy'
    }).datepicker('setDate', null);

    $("#latestMoveInDate").datepicker({
      altField: '#field-latestMoveInDate',
      dateFormat : 'dd-mm-yy'
    }).datepicker('setDate', null);

    $("#earliestMoveOutDate").datepicker({
      altField: '#field-earliestMoveOutDate',
      dateFormat : 'dd-mm-yy'
    }).datepicker('setDate', null);

    $("#latestMoveOutDate").datepicker({
      altField: '#field-latestMoveOutDate',
      dateFormat : 'dd-mm-yy'
    }).datepicker('setDate', null);




    /**
     * Initiate autocompletion for localities
     */
    $("#city").autocomplete({
      minLength : 2,
      enabled : true,
      autoFocus : true,
      source : $.flatfindr.ZIP_CODES
    });




    /**
     * Align the focused or cliced element to top of the visible part of the
     * scrollable $container_scroll.
     *
     * @private
     */
    function alignInputToTop() {
      var
        $this = $(this),
        offset_mod = 0;

      if ($this.is('.js-has-label')) {
        offset_mod =
          $this
            .parents('.row')
            .first()
            .find('label')
            .outerHeight();
      }

      animateScrollTop(
        $container_scroll.scrollTop() + $(this).position().top - offset_mod
      );
    }



    /**
     * Align $container_scroll to top, so scrollTop position is 0.
     *
     * @private
     */
    function alignTop() {
      animateScrollTop(0);
    }



    /**
     * Animate the change of the scrollTop position of the scrollable
     * element $container_scroll.
     *
     * @private
     * @param  {number} scrollTop the new scroll position to be animated to.
     */
    function animateScrollTop(scrollTop) {
      $container_scroll
        .delay(DURATION_BUFFER)
        .animate({scrollTop: scrollTop}, $.flatfindr.BASE_DURATION);
    }



    /**
     * Validate form inputs.
     *
     * @private
     * @param  {Object} form the form to be validated
     */
    function validateType(form) {
    	var
        room = document.getElementById('room'),
        studio = document.getElementById('studio'),
        house = document.getElementById('house'),
    	  neither = document.getElementById('neither');

    	neither.checked = false;

    	if(!room.checked && !studio.checked && !house.checked) {
    		neither.checked = true;
    	}
    }

  }
});
