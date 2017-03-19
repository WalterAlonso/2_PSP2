<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center">
  <div class="container">    
    <h3>CALCULO DE TAMA&Ntilde;O RELATIVO</h3>
  </div>
</div>
<div class="container">
  <table class="table table-striped">
	<tr>
		<th></th>
		<th>Very Small (VS)</th>
		<th>Small (S)</th>
		<th>Medium (M)</th>
		<th>Large (L)</th>
		<th>Very Large (VL)</th>
	</tr>
	<tr>
		<td>${TipoCategoriaLoc}</td>
		<td>${TipoCategoriaLocVS}</td>
		<td>${TipoCategoriaLocS}</td>
		<td>${TipoCategoriaLocM}</td>
		<td>${TipoCategoriaLocL}</td>
		<td>${TipoCategoriaLocVL}</td>
	</tr>
	<tr>
		<td>${TipoCategoriaCapitulo}</td>
		<td>${TipoCategoriaCapituloVS}</td>
		<td>${TipoCategoriaCapituloS}</td>
		<td>${TipoCategoriaCapituloM}</td>
		<td>${TipoCategoriaCapituloL}</td>
		<td>${TipoCategoriaCapituloVL}</td>
	</tr>
  </table>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('[name ^= "lnkArchivo"]').removeClass('active');
        $('[name = "lnkHome"]').addClass('active');
    });
</script>
</body>
</html>
