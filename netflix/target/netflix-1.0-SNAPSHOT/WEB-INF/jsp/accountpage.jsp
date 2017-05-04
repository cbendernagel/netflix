<%-- 
    Document   : settings
    Created on : May 2, 2017, 11:50:41 PM
    Author     : reggs
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

            <h2 class="spacing movietitle padding" style="text-align: center;">Hello ${account.customer.person.firstname}</h2>

            <h2 class="spacing accountfont underline">Orders</h2>
            <hr>

            <!-- Start My Rentals Carousel -->
            <div class="recent-projects">
                <h2 class="spacing accountfont underline">My Rentals</h2>
                <c:forEach var="order" items="${rentals}" step="4" varStatus="loop">
                    <div class="row spacing">

                        <div class = col-md-3>
                            <a class="" href="ratemoviepage/${order.movie.id}">
                                <h1>${order.movie.name}</h1>
                            </a>
                        </div>
                        <div class = col-md-3>
                            <a class="" href="ratemoviepage/${orders[loop.index+1].movie.id}">
                                <h1>${orders[loop.index+1].movie.name}</h1>
                            </a>
                        </div>
                        <div class = col-md-3>
                            <a class="" href="movieinfopage/${orders[loop.index+2].movie.id}">
                                <h1>${orders[loop.index+2].movie.name}</h1>
                            </a>
                        </div>
                        <div class = col-md-3>
                            <a class="" href="ratemoviepage/${orders[loop.index+3].movie.id}">
                                <h1>${orders[loop.index+3].movie.name}</h1>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            
            
            <!-- End My Movies Carousel -->
            <hr>
            
            <h2 class="spacing accountfont underline">Account Settings</h2>
                <div class="col-md-6 spacing list-group genretable">
                    <div class="col-md-6 spacing list-group genretable">
                        <a href="/netflix/account/${account.id}" class="list-group-item list-group-item-action">${account.id}</a>
                        <a href="/netflix/account/${account.id}" class="list-group-item list-group-item-action">${account.acctType.type}</a>
                        <a href="/netflix/account/${account.id}" class="list-group-item list-group-item-action">${account.customer.email}</a>
                        <a href="/netflix/account/${account.id}" class="list-group-item list-group-item-action">${account.customer.ccn}</a>
                        <a href="/netflix/account/${customer.id}" class="list-group-item list-group-item-action">${account.customer.person.telephone}</a>
                    </div>
                </div>

        </div>




        <!-- Start Footer Section -->
        <footer class="itemcenter">
            <div class="container">
                <div class="footer-widget social-widget">
                    <h4>Database Squad</h4>
                    <h6>Charles Bendernagel, Ryan Rego, Patrick Liao</h6>

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
                            <p>Copyright © 2016 Margo - Designed &amp; Developed by <a href="/netflix/http://graygrids.com">GrayGrids</a></p>
                        </div>
                        <!-- .col-md-6 -->
                        <div class="col-md-6">
                            <ul class="footer-nav">
                                <li><a href="/netflix/#">Sitemap</a>
                                </li>
                                <li><a href="/netflix/#">Privacy Policy</a>
                                </li>
                                <li><a href="/netflix/#">Contact</a>
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
    <a href="/netflix/#" class="back-to-top"><i class="fa fa-angle-up"></i></a>

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


</body>
</html>

