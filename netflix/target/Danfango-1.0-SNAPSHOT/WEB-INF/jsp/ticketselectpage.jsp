<%-- 
    Document   : ticketselectpage
    Created on : Apr 3, 2017, 7:22:00 PM
    Author     : johnlegutko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <link href="<c:url value="/resources/css/jquery-ui-1.10.1.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/settings.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/slicknav.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/colors/red.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">
        <link href="<c:url value = "https://fonts.googleapis.com/css?family=Press+Start+2P|Roboto|Work+Sans:200|Josefin+Sans:100i" /> rel="stylesheet">
        <link href="<c:url value="/resources/jquery.bxslider/jquery.bxslider.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet">

    </head>
    <body>

        <jsp:include page="header.jsp" />

        <div class="spacing container">

            <h2 class="spacing movietitle padding">MOVIE THEATRES & TIMES</h2>

            <div class="spacing dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Nearby Theatres
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="/danfango/#">Theatre</a></li>
                    <li><a href="/danfango/#">Theatre</a></li>
                    <li><a href="/danfango/#">Theatre</a></li>
                    <li><a href="/danfango/#">Theatre</a></li>
                    <li><a href="/danfango/#">Theatre</a></li>
                    <li><a href="/danfango/#">Theatre</a></li>
                </ul>
            </div>

            <div class="row form-group">
                <div class="col-sm-3">
                    <img class="spacing movieposter" src=${movie.poster}/>
                </div>



                <div class ="spacing col-sm-6">

                    <div class="theatreTimes">
                        <h4 class="theatreTimeCardsName">Movie Theatre Name <i id="favorite" class="fa fa-heart fa-inverse" aria-hidden="true" ></i></h4>
                        <p class="theatreTimeCardsAddress">Movie Theatre Address</p>
                        <p class ="ticketInfo"><i class="fa fa-registered" aria-hidden="true"></i> Reserved Seating</p>
                        <p class ="ticketInfo"><i class="fa fa-ticket" aria-hidden="true"></i> Select a movie time to buy tickets</p>

                        <div class="theatreTimeCardsTimes">
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">3:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">5:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">5:30PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">5:50PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">6:30PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">7:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">8:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">8:30PM</a>

                        </div>
                    </div>

                    <div class="theatreTimes">
                        <h4 class="theatreTimeCardsName">Movie Theatre Name <i id="favorite" class="fa fa-heart fa-inverse" aria-hidden="true"></i></h4>
                        <p class="theatreTimeCardsAddress">Movie Theatre Address</p>
                        <p class ="ticketInfo"><i class="fa fa-ticket" aria-hidden="true"></i> Select a movie time to buy tickets</p>
                        <div class="theatreTimeCardsTimes">
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">3:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">5:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">7:30PM</a>
                        </div>
                    </div>

                    <div class="theatreTimes">
                        <h4 class="theatreTimeCardsName">Movie Theatre Name <i id="favorite" class="fa fa-heart fa-inverse" aria-hidden="true"></i></h4>
                        <p class="theatreTimeCardsAddress">Movie Theatre Address</p>
                        <p class ="ticketInfo"><i class="fa fa-ticket" aria-hidden="true"></i> Select a movie time to buy tickets</p>
                        <div class="theatreTimeCardsTimes">
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">3:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">5:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">7:30PM</a>
                        </div>
                    </div>

                    <div class="theatreTimes">
                        <h4 class="theatreTimeCardsName">Movie Theatre Name <i id="favorite" class="fa fa-heart fa-inverse" aria-hidden="true"></i></h4>
                        <p class="theatreTimeCardsAddress">Movie Theatre Address</p>
                        <p class ="ticketInfo"><i class="fa fa-ticket" aria-hidden="true"></i> Select a movie time to buy tickets</p>
                        <div class="theatreTimeCardsTimes">
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">3:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">5:00PM</a>
                            <a href="/danfango/checkoutpage.html" class="btn btn-primary timeButton">7:30PM</a>
                        </div>
                    </div>


                </div>

                <div class="col-sm-3"></div>

            </div>
        </div>


    </div>
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
<script src="<c:url value="/resources/js/notify.min.js" />"></script>


<script src="<c:url value="/resources/js/myjs.js" />"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>

</body>
</html>
