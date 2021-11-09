$(function(){

    $('.umidade').keyup(function(){

       if ($(this).val() < 0) $(this).val(0);
       if ($(this).val() > 100) $(this).val(100);
   });

   $('.temperatura').keyup(function(){

        if ($(this).val() < -25) $(this).val(-25);
        if ($(this).val() > 45) $(this).val(45);
   });


});