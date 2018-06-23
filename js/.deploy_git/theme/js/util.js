function animation(  ){
}
animation.prototype.interval = null;
animation.prototype.interval2 = null;
animation.prototype.progress_state = 0;
animation.prototype.progress_direction = 1; // 1 = CLOCKWISE, -1 = COUNTERCLOCKWISE
animation.prototype.thunder_count = 0;
animation.prototype.thunder_old_color = "black";

animation.prototype.progress = function( span_tag, direction ){
	if( animation.prototype.interval == null ){
		animation.prototype.progress_direction = direction;

		animation.prototype.interval = setInterval(
		function(){
			var frames = ["\\", "|", "/", "-"];
		
			// controller
			if( animation.prototype.progress_direction == 1 ){
				animation.prototype.progress_state++;
				
				if( animation.prototype.progress_state > frames.length - 1 ){
					animation.prototype.progress_state = 0;
				}
			}else{
				animation.prototype.progress_state--;
				
				if( animation.prototype.progress_state < 0 ){
					animation.prototype.progress_state = frames.length - 1;
				}
			}
			
			// view
			span_tag.textContent = frames[ animation.prototype.progress_state ];
		}, 150 );
	}
};

animation.prototype.thunder = function( fnt ){
	if( animation.prototype.interval2 == null ){
		animation.prototype.thunder_old_color = fnt.color;
		
		animation.prototype.interval2 = setInterval(
		function(){
			
			if( ++animation.prototype.thunder_count < 25 ){
				if( fnt.color != animation.prototype.thunder_old_color ) fnt.color = animation.prototype.thunder_old_color;
				
				// console.log('tick');
			}else{
				animation.prototype.thunder_count = 0;
					
				fnt.color = "white";
				// console.log('blap blap blap blap');
			}
			
		}, 150 );
	}
};

window.onload = function(){
	var txt = document.getElementById("txt_ani");
	var mqu = document.getElementById("main_quote");

	var ani = new animation();
	ani.progress( txt, 1 );
	
	// var ani2 = new animation();
	// ani2.thunder( mqu );
};