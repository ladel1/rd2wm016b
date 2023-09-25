let ckAchats = document.querySelectorAll('.ck-achats input[type="checkbox"]');
let ckVentes = document.querySelectorAll('.ck-ventes input[type="checkbox"]');

function change(event){
	if(event.target.value==="achats"){
		ckAchats.forEach( node=>{
			node.removeAttribute("disabled");
		} );
		ckVentes.forEach( node=>{
			node.setAttribute("disabled","true");
			node.checked = false;
		} );
	}else{
		ckAchats.forEach( node=>{
			node.setAttribute("disabled","true");
			node.checked = false;
		} );
		ckVentes.forEach( node=>{
			node.removeAttribute("disabled");
		} );
	}
}