<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="/resources/js/prod/${param.js}.js"></script>
<script>

	(function ($, pagename) {

		var js = {
			common: function () {
				return $.flatfindr
					.with({
						PAGE_NAME: pagename,
						ZIP_CODES: <c:import url="getzipcodes.jsp" />
					})
					.add(['header']);
			},

			login: function () {
				return $.flatfindr.add([
					'search'
				]);
			},

			signup: function () {
				return $.flatfindr.add([
					'search',
					'signup'
				]);
			},

			register: function () {
				/**
		     * Initiate autocompletion for localities
		     */
		    $("#city").autocomplete({
		      minLength : 2,
		      enabled : true,
		      autoFocus : true,
		      source : $.flatfindr.ZIP_CODES
		    });
			},

			alerts: function () {

				function deleteAlert(button) {
					var id = $(button).attr("data-id");
					$.get("/profile/alerts/deleteAlert?id=" + id, function(){
						$("#alertsDiv").load(document.URL + " #alertsDiv");
					});
				}

				// $(document).ready(function() {
				// 	$("#city").autocomplete({
				// 		minLength : 2
				// 	});
				// 	$("#city").autocomplete({
				// 		source : <c:import url="getzipcodes.jsp" />
				// 	});
				// 	$("#city").autocomplete("option", {
				// 		enabled : true,
				// 		autoFocus : true
				// 	});
				//
				// 	var price = document.getElementById('priceInput');
				// 	var radius = document.getElementById('radiusInput');
				//
				// 	if(price.value == null || price.value == "" || price.value == "0")
				// 		price.value = "500";
				// 	if(radius.value == null || radius.value == "" || radius.value == "0")
				// 		radius.value = "5";
				// });
				//

				return $.flatfindr.add


			},

			updatedProfile: function () {
				return;
			},

			myRooms: function () {
				$('.list-delete-link').on('click touch', function (e) {
					e.preventDefault();

					$(this)
						.parents('.row').first()
						.find('.deletion-confirm')
						.toggleClass('js-confirm');
				});

				$('.action-cancel').on('click touch', function(e) {
					e.preventDefault();

					$(this)
						.parents('.deletion-confirm')
						.removeClass('js-confirm');
				});

				return $.flatfindr.add([
					'search'
				]);
			},

			user: function () {
				return $.flatfindr
					.with({ username: '${user.username}' })
					.add([
						'search',
						'message'
					]);
			},

			editProfile: function () {
				return $.flatfindr
					.with({
						popul: { '#about-me': {
							val: "${currentUser.aboutMe}"
						}}
					})
					.add([
						'imageUpload',
						'populate'
					])
			},

			index: function () {
				return $.flatfindr.add([
					'search',
					'sliderBlender',
					'sliderBlenderCaption'
				]);
			},

			searchAd: function () {
				return $.flatfindr.add([
					'search'
				]);
			},

			results: function () {
				return $.flatfindr.add([
					'filter',
					'map'
				]);
			},

			placeAd: function () {
				return $.flatfindr.add([
					'place',
					'imageUpload'
				]);
			},

			editAd: function () {
				return js.placeAd();
			},

			placeAuction: function () {
				return js.placeAd();
			}
		};

		js.common();
		pagename in js && js[pagename]();

	})(jQuery, '${param.js}');
</script>

<c:choose>
    <c:when test="${param.map=='1'}">
			<script
				async
				defer
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAh9mJhrCy-xTWy5b3Niop8QilZAdMh1To&callback=initMap">
			</script>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>

<script src="js/hotfix.js"></script>

</body>
</html>
