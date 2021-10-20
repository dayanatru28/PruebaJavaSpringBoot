function eliminar(id) {
	swal({
		title: "Esta seguro de eliminar?",
		text: "Una vez borrado, no se puede recuperar",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarEstudiante/"+id,
					success: function(res){
						console.log(res);
					}
				})
				
				swal("Poof! Your imaginary file has been deleted!", {
					icon: "success",
				}).then((OK)=>{
					if(OK){
						location.href="/listarEstudiantes/";
					}
				});
			} else {
				swal("Your imaginary file is safe!");
			}
		});
}