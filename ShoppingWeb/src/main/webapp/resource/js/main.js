/**
 * 
 */

        $(document).ready(function(){
    $("#main_menu").hover(function(){
        $("#show_main_menu").stop(true,false,true).slideToggle("fast");
    });
});


        $(document).ready(function(){
    $("#main_menu1").hover(function(){
        $("#show_main_menu1").stop(true,false,true).slideToggle("fast");
    });
});


$(document).ready(function(){
    $("#header_middle_cart").click(function(){
        $("#cart_toggle").stop(true,false,true).slideToggle("slow");
    });
});

        $("#myCarousel").hover(function(){
            $("#myCarousel").addClass(".left");
            $("#myCarousel").addClass(".right");
        });

	$(function() { 
		    $(function() {  
        		 var pull = $('#pull');  
           		 menu = $('.header_menu_bg .main_menu_bg');  
            	 menuHeight  = menu.height();  
      
        		$(pull).on('click', function(e) {  
           			 e.preventDefault();  
           		 menu.slideToggle();  
        		});  
    		});  

    		$(window).resize(function(){  
        		var w = $(window).width();  
        		if(w > 320 && menu.is(':hidden')) {  
           		 menu.removeAttr('submenu_v2');  
        	}  
   		 });    
    });  
$(document).ready(function(){
	$("#review_item_toggle").click(function(){
		$("#review_item_show").stop(true,false,true).slideToggle();
	})
})
$(document).ready(function(){
	 $('a[href*=#]:not([href=#])').click(function() {
	        var target = $(this.hash);
	        target = target.length ? target : $('[name=' + this.hash.substr(1) +']');
	        if (target.length) {
	            $('html,body').animate({
	              scrollTop: target.offset().top
	            }, 1000);
	            return false;
	        }
	    });
})


