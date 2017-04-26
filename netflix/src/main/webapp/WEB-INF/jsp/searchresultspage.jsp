<%-- 
    Document   : searchresultspage
    Created on : Apr 3, 2017, 7:16:52 PM
    Author     : johnlegutko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/settings.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/slicknav.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/colors/red.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/jquery.bxslider/jquery.bxslider.css"/>" rel="stylesheet">

        <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet">
    </head>
    <body>

        <jsp:include page="header.jsp" />

        <div class="spacing container">

            <h2 class="spacing movietitle">SEARCH <font color="EA6630"><b>RESULTS</b></font></h2>

            <h1 class="spacing accountfont underline">Movies</h1>


            <c:forEach var="movie" items="${movies}" step="4" varStatus="loop">
                <div class="row spacing">
                    <div class = col-md-3>
                        <h6>${movie.name}</h6>
                        <c:if test="${movie.poster != null && movie.poster != 'null'}">
                            <a class="" href="movieinfopage/${movie.id}">
                                <img class ="posters" src="https://image.tmdb.org/t/p/w500/${movie.poster}">
                            </a>
                        </c:if>
                    </div>
                    <div class = col-md-3>
                        <h6>${movies[loop.index+1].name}</h6>
                        <c:if test="${movies[loop.index+1].poster != null && movies[loop.index+1].poster != 'null'}">
                            <a class="" href="movieinfopage/${movies[loop.index+1].id}">
                                <img class ="posters" src="https://image.tmdb.org/t/p/w500/${movies[loop.index+1].poster}">
                            </a>
                        </c:if>
                    </div>
                    <div class = col-md-3>
                        <h6>${movies[loop.index+2].name}</h6>
                        <c:if test="${movies[loop.index+2].poster != null && movies[loop.index+2].poster != 'null'}">
                            <a class="" href="movieinfopage/${movies[loop.index+2].id}">
                                <img class ="posters" src="https://image.tmdb.org/t/p/w500/${movies[loop.index+2].poster}">
                            </a>
                        </c:if>
                    </div>
                    <div class = col-md-3>
                        <h6>${movies[loop.index+3].name}</h6>
                        <c:if test="${movies[loop.index+3].poster != null && movies[loop.index+3].poster != 'null'}">
                            <a class="" href="movieinfopage/${movies[loop.index+3].id}">
                                <img class ="posters" src="https://image.tmdb.org/t/p/w500/${movies[loop.index+3].poster}">
                            </a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>

            <h1 class="spacing accountfont underline">Actors</h1>
            <c:forEach items="${crew}" var="crewMember" step="4" varStatus="loop">
                <div class="row spacing">
                    <div class = col-md-3>
                        <h6>${crewMember.name}</h6>
                        <a class="" href="actorinfopage/${crewMember.id}">
                            <img class ="posters" src="https://image.tmdb.org/t/p/w500/${crewMember.poster}">
                        </a>
                    </div>
                    <div class = col-md-3>
                        <h6>${crew[loop.index+1].name}</h6>
                        <a class="" href="actorinfopage/${crew[loop.index+1].id}">
                            <img class ="posters" src="https://image.tmdb.org/t/p/w500/${crew[loop.index+1].poster}">
                        </a>
                    </div>
                    <div class = col-md-3>
                        <h6>${crew[loop.index+2].name}</h6>
                        <a class="" href="actorinfopage/${crew[loop.index+2].id}">
                            <img class ="posters" src="https://image.tmdb.org/t/p/w500/${crew[loop.index+2].poster}">
                        </a>
                    </div>
                    <div class = col-md-3>
                        <h6>${crew[loop.index+3].name}</h6>
                        <a class="" href="actorinfopage/${crew[loop.index+3].id}">
                            <img class ="posters" src="https://image.tmdb.org/t/p/w500/${crew[loop.index+3].poster}">
                        </a>
                    </div>
                </div>
            </c:forEach>

            <h1 class="spacing accountfont underline">Theatres by Name</h1>
            <c:forEach items="${theatresByName}" var="theatre">
                <p>${theatre.id} : ${theatre.name}<p>
                </c:forEach>
            <h1 class="spacing accountfont underline">Theatres by Location</h1>
            <c:forEach items="${theatresByLocation}" var="theatre">
                <p>${theatre.id} : ${theatre.name}<p>
                </c:forEach>
            <h1 class="spacing accountfont underline">Suggestions</h1>
            <c:forEach items="${locations}" var="location">
                <p>${location.city}, ${location.state}<p>
                </c:forEach>
        </div>




        <!-- Start Footer Section -->
        <footer class="itemcenter">
            <div class="container">
                <div class="footer-widget social-widget">
                    <h4>Anti-Graduation Squad</h4>
                    <h6>ft. John Legutko, Joseph Giardina, Konrad Juszkiewicz, Charles Bendernagel</h6>

                    <h4>Follow Us<span class="head-line"></span></h4>
                    <ul class="social-icons">
                        <li>
                            <a class="facebook" href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a class="twitter" href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a class="google" href="#"><i class="fa fa-google-plus"></i></a>
                        </li>
                        <li>
                            <a class="instgram" href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                    </ul>
                </div>
                <!-- .row -->
                <!-- Start Copyright -->
                <div class="copyright-section">
                    <div class="row">
                        <div class="col-md-6">
                            <p>Copyright © 2016 Margo - Designed &amp; Developed by <a href="/danfango/http://graygrids.com">GrayGrids</a></p>
                        </div>
                        <!-- .col-md-6 -->
                        <div class="col-md-6">
                            <ul class="footer-nav">
                                <li><a href="/danfango/#">Sitemap</a>
                                </li>
                                <li><a href="/danfango/#">Privacy Policy</a>
                                </li>
                                <li><a href="/danfango/#">Contact</a>
                                </li>
                            </ul>
                        </div>
                        <!-- .col-md-6 -->
                    </div>
                    <!-- .row -->
                </div>
                <!-- End Copyright -->

            </div>
        </footer>
        <!-- End Footer Section -->


    </div>
    <!-- End Full Body Container -->

    <!-- Go To Top Link -->
    <a href="/danfango/#" class="back-to-top"><i class="fa fa-angle-up"></i></a>

    <div id="loader">
        <div class="spinner">
            <div class="dot1"></div>
            <div class="dot2"></div>
        </div>
    </div>


    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.migrate.js" />"></script>
    <script src="<c:url value="/resources/js/modernizrr.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.fitvids.js" />"></script>
    <script src="<c:url value="/resources/js/owl.carousel.min.js" />"></script>
    <script src="<c:url value="/resources/js/nivo-lightbox.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.isotope.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.appear.js" />"></script>
    <script src="<c:url value="/resources/js/count-to.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.textillate.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.lettering.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.easypiechart.min.js" />"></script>
    <script src="<c:url value="/resources/js/smooth-scroll.js" />"></script>
    <script src="<c:url value="/resources/js/skrollr.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.parallax.js" />"></script>
    <script src="<c:url value="/resources/js/mediaelement-and-player.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.slicknav.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.themepunch.revolution.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.themepunch.tools.min.js" />"></script>
    <script src="<c:url value="/resources/jquery.bxslider/jquery.bxslider.min.js" />"></script>
    <script src="<c:url value="/resources/js/myjs.js" />"></script>
    <script src="<c:url value="/resources/js/script.js" />"></script>

</body>
</html>
