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
				.add(['header'])
				.then('bits', 'unreadMessages');
		},

		adDescription: function () {
			return $.flatfindr
				.with({
					advertisementID: '${shownAd.id}',
					advertisement: '${shownAd}',
					username: '${shownAd.user.username}'
				})
				.add(['sidebar', 'sliderBlender', 'bookmark', 'message', 'enquiry'])
				.then('sliderBlender', 'addOnClickNavigation');
		},

		auctionDescription: function () {
			return $.flatfindr
				.with({
					advertisementID: '${shownAuction.id}',
					advertisement: '${shownAuction}',
					username: '${shownAuction.user.username}'
				})
				.add(['sidebar', 'sliderBlender', 'bookmark', 'message', 'enquiry'])
				.then('sliderBlender', 'addOnClickNavigation');
		}
	};

	js.common();
	pagename in js && js[pagename]();

})(jQuery, '${param.js}');
</script>

</body>
</html>
