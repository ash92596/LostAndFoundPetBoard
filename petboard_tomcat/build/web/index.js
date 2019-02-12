function onLoginBtnClick (){
	if($('.login').css('display') == 'none')
	{
		$('.sign-up').hide();
		$('.login').show();	

	}

}

function onSignupBtnClick (){
	if($('.sign-up').css('display') == 'none')
	{
			$('.sign-up').show();
			$('.login').hide();	

	}

}