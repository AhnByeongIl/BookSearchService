<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="d-flex fixed-top align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a id="home" class="navbar-brand mr-md-auto logo" href="/">Book Search Service</a>
    <nav id="nav" class="my-2 my-md-0 mr-md-3">
                    <a id="bookSearch" class="p-2 text-dark" href="/book/search">Search</a>
                    <a id="mHistory" class="p-2 text-dark" href="/book/myhistory">My History</a>
                    <a id="topTen" class="p-2 text-dark" href="/book/topten">Top10</a>
    </nav>

    <div id="accountArea">
        <sec:authorize access="!isAuthenticated()"><a id="login" class="btn btn-outline-primary" style="margin-right:5px;" href="/account/login">Log in</a></sec:authorize>
        <sec:authorize access="isAuthenticated()"><a id="logout" class="btn btn-outline-primary" style="margin-right:5px;" href="/account/logout">Log out</a></sec:authorize>
        <a id="signUp" class="btn btn-outline-primary" href="/account/signUp">Sign up</a>
    </div>
</div>

<script>
(function (window, $, undefined) {
    var header = {
        init: function() {

        },
        eventbinding: function() {

        }
    };

})(window, jQuery);

</script>