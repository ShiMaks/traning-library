<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE>
<html class='no-js' lang='en'>
	<!--<![endif]-->
	<head>
		<meta charset='utf-8' />
		<meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible' />
		<title>Administrator</title>	
		
		<link rel="shortcut icon" href="favicon.ico" />
		<link rel="apple-touch-icon" href="images/favicon.png" />
		
		<link rel="stylesheet" href="css/maximage.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/styles.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/style1.css">
		
		<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
		
		<!--[if IE 6]>
			<style type="text/css" media="screen">
				.gradient {display:none;}
			</style>
		<![endif]-->
	</head>
<body>

		<div class="container">
			<h2 class="heading">Hello Admin</h2>
		</div>
	
	<h3>Update book</h3>
	<form name="updateBook" action="SimpleServlet" method="POST">
	<input type="hidden" name="command" value="updateBook" />
			<tr>
				<td>BookId:</td>
				<td><input type="text" name="bookId" value = <c:out value="${idBook}"/>></td>
			</tr>
	
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<td>Author:</td>
					<td>
					<!--<select name="author">
							<c:forEach items="${updateBook}" var="book" >
								<option>
								<c:out value="${book.getAuthor()}" />
								</option>
							</c:forEach>
						<option selected value="-">-</option>
					</select>-->
					
					<input type="text" name="author" list="authorname">
					<datalist id="authorname">
					  <c:forEach items="${updateBook}" var="book" >
								<option>
								<c:out value="${book.getAuthor()}" />
								</option>
							</c:forEach>
					</datalist>
						
				<td/>
			</tr>
			<!--<tr>
				
			   <td>Выберите дату:</td>
			   <td> 
			   <input type="date" name="calendar"
			    max="2017-02-20" min="1890-05-29">
 				</td>	
			</tr>-->
			
			<tr>
				<td>Select a date:</td>
					<td>
					<select name="date">
							<c:forEach items="${updateYear}" var="year" >
								<option>
								<c:out value="${year}" />
								</option>
							</c:forEach>
						<option selected value="-">-</option>
					</select>	
				<td/>
			</tr>
			
			<input type="submit" value="Update Book">
	</form>	
	<br>
	
	<div id="maximage">
			<div>
				<img src="images/backgrounds/bg-img-1.jpg" alt="" />
				<img class="gradient" src="images/backgrounds/gradient.png" alt="" />
			</div>
			<div>
				<img src="images/backgrounds/bg-img-2.jpg" alt="" />
				<img class="gradient" src="images/backgrounds/gradient.png" alt="" />
			</div>
			<div>
				<img src="images/backgrounds/bg-img-3.jpg" alt="" />
				<img class="gradient" src="images/backgrounds/gradient.png" alt="" />
			</div>
			<div>
				<img src="images/backgrounds/bg-img-4.jpg" alt="" />
				<img class="gradient" src="images/backgrounds/gradient.png" alt="" />
			</div>
			<div>
				<img src="images/backgrounds/bg-img-5.jpg" alt="" />
				<img class="gradient" src="images/backgrounds/gradient.png" alt="" />
			</div>
		</div>
		
		<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.js'></script>
		<script src="js/jquery.easing.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.cycle.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.maximage.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.fullscreen.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.ba-hashchange.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript" charset="utf-8">
			$(function(){
				$('#maximage').maximage({
					cycleOptions: {
						fx: 'fade',
						speed: 1000, // Has to match the speed for CSS transitions in jQuery.maximage.css (lines 30 - 33)
						timeout: 5000,
						prev: '#arrow_left',
						next: '#arrow_right',
						pause: 0,
						before: function(last,current){
							if(!$.browser.msie){
								// Start HTML5 video when you arrive
								if($(current).find('video').length > 0) $(current).find('video')[0].play();
							}
						},
						after: function(last,current){
							if(!$.browser.msie){
								// Pauses HTML5 video when you leave it
								if($(last).find('video').length > 0) $(last).find('video')[0].pause();
							}
						}
					},
					onFirstImageLoaded: function(){
						jQuery('#cycle-loader').hide();
						jQuery('#maximage').fadeIn('fast');
					}
				});
	
				// Helper function to Fill and Center the HTML5 Video
				jQuery('video,object').maximage('maxcover');
	
			});
		</script>

</body>
</html>