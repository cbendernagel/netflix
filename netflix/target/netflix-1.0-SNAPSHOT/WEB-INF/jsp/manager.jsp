<%-- 
    Document   : manager
    Created on : May 2, 2017, 9:36:30 PM
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
        
        <!-- Add Movie-->
        <div class="spacing container joinmargin">

            <div class="row">
                <div class="col-md-6 spacing border">

                    <h1 class="spacing">ADD A MOVIE<font color="EA6630"><b></b></font></h1>
                    <form role="form" id="contactForm" class="signupform spacing" data-toggle="validator" class="shake" method="POST" action="/netflix/addMovie">
                        
                        
                        <div class="controls">
                            <input type="text" name="moviename" id="moviename" placeholder="Movie Name" required data-error="Please enter the Movie Name">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="type" id="type" placeholder="Movie Genre" required data-error="Please enter the Movie Genre">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="rating" id="rating" placeholder="Movie Rating">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="distrFee" id="distrFee" placeholder="Distribution Fees">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="numCopies" id="numCopies" placeholder="Number of Copies">
                            <div class="help-block with-errors"></div>
                        </div>
                        <input type="submit" name="button" value="Add Movie" class="btn-system btn-large btn-gray joinbutton spacing">

                    </form>

                </div>
            </div>

        </div>
        
        <!-- Edit Movie -->
        <div class="spacing container joinmargin">

            <div class="row">
                <div class="col-md-6 spacing border">

                    <h1 class="spacing">EDIT A MOVIE<font color="EA6630"><b></b></font></h1>
                    <form role="form" id="contactForm" class="signupform spacing" data-toggle="validator" class="shake" method="POST" action="/netflix/editMovie">
                        
                        <div class="controls">
                            <input type="text" name="id" id="id" placeholder="Movie Id" required data-error="Please enter the Movie Id">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="moviename" id="moviename" placeholder="Movie Name">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="type" id="type" placeholder="Movie Genre">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="rating" id="rating" placeholder="Movie Rating">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="numCopies" id="numCopies" placeholder="Number of Copies">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="distrFee" id="distrFee" placeholder="Distribution Fee">
                            <div class="help-block with-errors"></div>
                        </div>
                        <input type="submit" name="button" value="Edit Movie" class="btn-system btn-large btn-gray joinbutton spacing">

                    </form>

                </div>
            </div>

        </div>
        <!-- Delete Movie -->
        <div class="spacing container joinmargin">

            <div class="row">
                <div class="col-md-6 spacing border">

                    <h1 class="spacing">DELETE A MOVIE<font color="EA6630"><b></b></font></h1>
                    <form role="form" id="contactForm" class="signupform spacing" data-toggle="validator" class="shake" method="POST" action="/netflix/deleteMovie">

                        <div class="controls">
                            <input type="text" name="id" id="id" placeholder="Movie id" required data-error="Please enter the Movie Id">
                            <div class="help-block with-errors"></div>
                        </div>
                        <input type="submit" name="button" value="Delete Movie" class="btn-system btn-large btn-gray joinbutton spacing">

                    </form>

                </div>
            </div>

        </div>
        <!-- Add an Employee -->
        <div class="spacing container joinmargin">

            <div class="row">
                <div class="col-md-6 spacing border">

                    <h1 class="spacing">ADD AN EMPLOYEE<font color="EA6630"><b></b></font></h1>
                    <form role="form" id="contactForm" class="signupform spacing" data-toggle="validator" class="shake" method="POST" action="/netflix/addEmployee">
                        
                        <div class="controls">
                            <input type="text" name="ssn" id="ssn" placeholder="Social Security Number" required data-error="Please enter the SSN">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="address" id="address" placeholder="Address">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="firstName" id="firstName" placeholder="First Name" required data-error="Please enter the First Name">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="lastName" id="lastName" placeholder="Last Name" required data-error="Please enter the Last Name">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="zipcode" id="zipcode" placeholder="Zip Code" required data-error="Please enter the Zip Code">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="city" id="city" placeholder="City">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="state" id="state" placeholder="State">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="telephone" id="telephone" placeholder="Telephone">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="hourlyRate" id="hourlyRate" placeholder="Hourly Rate">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        
                        <div class="controls">
                            <input type="text" name="type" id="type" placeholder="Employee Position" required data-error="Please enter the Position">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <input type="submit" name="button" value="Add Employee" class="btn-system btn-large btn-gray joinbutton spacing">

                    </form>

                </div>
            </div>

        </div>
        <!-- Edit an Employee -->
        <div class="spacing container joinmargin">

            <div class="row">
                <div class="col-md-6 spacing border">

                    <h1 class="spacing">EDIT EMPLOYEE[FILL EVERYTHING OUT]<font color="EA6630"><b></b></font></h1>
                    <form role="form" id="contactForm" class="signupform spacing" data-toggle="validator" class="shake" method="POST" action="/netflix/editEmployee">
                        
                        <div class="controls">
                            <input type="text" name="empid" id="empid" placeholder="Employee Id" required data-error="Please enter the Employee Id">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="ssn" id="ssn" placeholder="Social Security Number" required data-error="Please enter the SSN">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="address" id="address" placeholder="Address">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="firstName" id="firstName" placeholder="First Name" required data-error="Please enter the First Name">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="lastName" id="lastName" placeholder="Last Name" required data-error="Please enter the Last Name">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="zipcode" id="zipcode" placeholder="Zip Code" required data-error="Please enter the Zip Code">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="city" id="city" placeholder="City">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="state" id="state" placeholder="State">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="telephone" id="telephone" placeholder="Telephone">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="hourlyRate" id="hourlyRate" placeholder="Hourly Rate">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <div class="controls">
                            <input type="text" name="type" id="type" placeholder="Employee Position" required data-error="Please enter the Position">
                            <div class="help-block with-errors"></div>
                        </div>
                        
                        <input type="submit" name="button" value="Edit Employee" class="btn-system btn-large btn-gray joinbutton spacing">

                    </form>

                </div>
            </div>

        </div>
        <!-- Delete an Employee -->
        <div class="spacing container joinmargin">

            <div class="row">
                <div class="col-md-6 spacing border">

                    <h1 class="spacing">DELETE EMPLOYEE<font color="EA6630"><b></b></font></h1>
                    <form role="form" id="contactForm" class="signupform spacing" data-toggle="validator" class="shake" method="POST" action="/netflix/deleteEmployee">
                        
                        <div class="controls">
                            <input type="text" name="empid" id="empid" placeholder="Employee Id" required data-error="Please enter the Employee Id">
                            <div class="help-block with-errors"></div>
                        </div>
                        <input type="submit" name="button" value="Delete Employee" class="btn-system btn-large btn-gray joinbutton spacing">

                    </form>

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
                            <p>Copyright © 2016 Margo - Designed &amp; Developed by <a href="/danfango/http://graygrids.com">GrayGrids</a></p>
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
