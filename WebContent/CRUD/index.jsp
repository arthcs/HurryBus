<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Painel Do Usuario</title>

<!-- CSS Reset -->
<link rel="stylesheet" type="text/css" href="css/reset.css"
	media="screen" />

<!-- Fluid 960 Grid System - CSS framework -->
<link rel="stylesheet" type="text/css" href="css/grid.css"
	media="screen" />

<!-- IE Hacks for the Fluid 960 Grid System -->
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="ie6.css" tppabs="http://www.xooom.pl/work/magicadmin/css/ie6.css" media="screen" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" href="ie.css" tppabs="http://www.xooom.pl/work/magicadmin/css/ie.css" media="screen" /><![endif]-->

<!-- Main stylesheet -->
<link rel="stylesheet" type="text/css" href="css/styles.css"
	media="screen" />

<!-- WYSIWYG editor stylesheet -->
<link rel="stylesheet" type="text/css" href="css/jquery.wysiwyg.css"
	media="screen" />

<!-- Table sorter stylesheet -->
<link rel="stylesheet" type="text/css" href="css/tablesorter.css"
	media="screen" />

<!-- Thickbox stylesheet -->
<link rel="stylesheet" type="text/css" href="css/thickbox.css"
	media="screen" />

<!-- Themes. Below are several color themes. Uncomment the line of your choice to switch to different color. All styles commented out means blue theme. -->
<link rel="stylesheet" type="text/css" href="css/theme-blue.css"
	media="screen" />
<!--<link rel="stylesheet" type="text/css" href="css/theme-red.css" media="screen" />-->
<!--<link rel="stylesheet" type="text/css" href="css/theme-yellow.css" media="screen" />-->
<!--<link rel="stylesheet" type="text/css" href="css/theme-green.css" media="screen" />-->
<!--<link rel="stylesheet" type="text/css" href="css/theme-graphite.css" media="screen" />-->

<!-- JQuery engine script-->
<script type="text/javascript" src="jquery-1.3.2.min.js"></script>

<!-- JQuery WYSIWYG plugin script -->
<script type="text/javascript" src="jquery.wysiwyg.js"></script>

<!-- JQuery tablesorter plugin script-->
<script type="text/javascript" src="jquery.tablesorter.min.js"></script>

<!-- JQuery pager plugin script for tablesorter tables -->
<script type="text/javascript" src="jquery.tablesorter.pager.js"></script>

<!-- JQuery password strength plugin script -->
<script type="text/javascript" src="jquery.pstrength-min.1.2.js"></script>

<!-- JQuery thickbox plugin script -->
<script type="text/javascript" src="script/thickbox.js"></script>

<!-- Initiate WYIWYG text area -->
<script type="text/javascript">
	$(function() {
		$('#wysiwyg').wysiwyg({
			controls : {
				separator01 : {
					visible : true
				},
				separator03 : {
					visible : true
				},
				separator04 : {
					visible : true
				},
				separator00 : {
					visible : true
				},
				separator07 : {
					visible : false
				},
				separator02 : {
					visible : false
				},
				separator08 : {
					visible : false
				},
				insertOrderedList : {
					visible : true
				},
				insertUnorderedList : {
					visible : true
				},
				undo : {
					visible : true
				},
				redo : {
					visible : true
				},
				justifyLeft : {
					visible : true
				},
				justifyCenter : {
					visible : true
				},
				justifyRight : {
					visible : true
				},
				justifyFull : {
					visible : true
				},
				subscript : {
					visible : true
				},
				superscript : {
					visible : true
				},
				underline : {
					visible : true
				},
				increaseFontSize : {
					visible : false
				},
				decreaseFontSize : {
					visible : false
				}
			}
		});
	});
</script>

<!-- Initiate tablesorter script -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter({
			// zebra coloring
			widgets : [ 'zebra' ],
			// pass the headers argument and assing a object 
			headers : {
				// assign the sixth column (we start counting zero) 
				6 : {
					// disable it by setting the property sorter to false 
					sorter : false
				}
			}
		}).tablesorterPager({
			container : $("#pager")
		});
	});
</script>

<!-- Initiate password strength script -->
<script type="text/javascript">
	$(function() {
		$('.password').pstrength();
	});
</script>

<link rel="stylesheet" href="css/styles.css" media="screen" />
<script src="js/jquery-2.1.3.js"></script>


</head>
<body>

	<div id="container">
		<div id="loader"></div>
		<div id="content">


			<!-- Header -->
			<div id="header">
				<!-- Header. Status part -->
				<div id="header-status">
					<div class="container_12">
						<div class="grid_8">&nbsp;</div>
						<div class="grid_4">
							<a href="" id="logout"> Sair </a>
						</div>
					</div>
					<div style="clear: both;"></div>
				</div>
				<!-- End #header-status -->

				<!-- Header. Main part -->
				<div id="header-main">
					<div class="container_12">
						<div class="grid_12">
							<div id="logo">
								<ul id="nav">
									<li id="current"><a href="">Dashboard</a></li>
									<!--  <li ><a href="">Articles</a></li>
                                <li><a href="">Files</a></li>
                                <li><a href="">Profile</a></li>
                                <li><a href="">Settings</a></li> -->
								</ul>
							</div>
							<!-- End. #Logo -->
						</div>
						<!-- End. .grid_12-->
						<div style="clear: both;"></div>
					</div>
					<!-- End. .container_12 -->
				</div>
				<!-- End #header-main -->
				<div style="clear: both;"></div>
				<!-- Sub navigation -->
				<div id="subnav">
					<div class="container_12">
						<div class="grid_12">
							<!-- <ul>
                            <li><a href="#">link 1</a></li>
                            <li><a href="#">link 2</a></li>
                            <li><a href="#">link 3</a></li>
                            <li><a href="#">link 4</a></li>
                            <li><a href="#">link 5</a></li>
                        </ul> -->

						</div>
						<!-- End. .grid_12-->
					</div>
					<!-- End. .container_12 -->
					<div style="clear: both;"></div>
				</div>
				<!-- End #subnav -->
			</div>
			<!-- End #header -->

			<div class="container_12">



				<!-- Dashboard icons -->
				<div class="grid_7">
					<a href="/HurryBus/CRUD/EventoAtualiza.jsp"
						class="dashboard-module"> <img
						src="imagem/Crystal_Clear_write.gif" width="64" height="64"
						alt="edit" /> <span>Atualizar Evento</span>
					</a> <a href="/HurryBus/CRUD/EventoCadastra.jsp"
						class="dashboard-module"> <img
						src="imagem/Crystal_Clear_file.gif" width="64" height="64"
						alt="edit" /> <span>Cadastrar evento</span>
					</a> <a href="/HurryBus/CRUD/EventoExclui.jsp" class="dashboard-module">
						<img src="imagem/cross-on-white.gif" width="64" height="64"
						alt="edit" /> <span>Excluir Evento</span>
					</a> <a href="/HurryBus/CRUD/UsuarioBusacaId.jsp"
						class="dashboard-module"> <img
						src="imagem/Crystal_Clear_user.gif" width="64" height="64"
						alt="edit" /> <span>Buscar Usuario por ID</span>
					</a> <a href="/HurryBus/CRUD/UsuarioAtualiza.jsp"
						class="dashboard-module"> <img
						src="imagem/Crystal_Clear_write.gif" width="64" height="64"
						alt="edit" /> <span>Atualiza Usuario</span>
					</a> <a href="/HurryBus/CRUD/UsuarioCadastra.jsp"
						class="dashboard-module"> <img
						src="imagem/Crystal_Clear_file.gif" width="64" height="64"
						alt="edit" /> <span>Cadastra Usuario</span>
					</a> <a href="/HurryBus/CRUD/UsuarioExcluir.jsp"
						class="dashboard-module"> <img src="imagem/cross-on-white.gif"
						width="64" height="64" alt="edit" /> <span>Excluir usuario</span>
					</a>
					<div style="clear: both"></div>
				</div>
				<!-- End .grid_7 -->
			</div>


			<div style="clear: both;"></div>


			<!-- Footer -->
			<div id="footer">
				<div class="container_12">
					<div class="grid_12"></div>
				</div>
				<div style="clear: both;"></div>
			</div>
			<!-- End #footer -->

		</div>
	</div>
	<script type="text/javascript">
		jQuery(window).load(function() {
			jQuery("#loader").delay(2000).fadeOut("slow");
		});
	</script>

</body>
</html>