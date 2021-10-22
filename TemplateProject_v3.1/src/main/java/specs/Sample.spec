@objects
	div-container			css			#summary
	header-confirmation		xpath		//*[text()='Appointment Confirmation']
	lbl-facility			css			[for='facility']
	value-facility			css			#facility
	lbl-readmission			css			[for='hospital_readmission']
	value-readmission		css			#hospital_readmission
	lbl-program				css			[for='program']
	value-program			css			#program
	lbl-visit-date			css			[for='visit_date']
	value-visit-date		css			#visit_date
	btn-homepage			css			.btn-default
	
= Confirmation Section =

	@on desktop
		div-container:
			inside screen 495 to 505px top
			height 425 to 435px
			
		header-confirmation:
			inside div-container 65 to 75px top
			text is "Appointment Confirmation"
			
		lbl-facility:
			inside div-container 180 to 190px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			text is "Facility"
			
		value-facility:
			inside div-container 180 to 190px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			near lbl-facility 200 to 210px right
			
		lbl-readmission:
			inside div-container 210 to 220px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			text is "Apply for hospital readmission"
			
		value-readmission:
			inside div-container 210 to 220px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			near lbl-readmission 60 to 70px right
			
		lbl-program:
			inside div-container 240 to 250px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			text is "Healthcare Program"
			
		value-program:
			inside div-container 240 to 250px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			near lbl-program 120 to 130px right
			
		lbl-visit-date:
			inside div-container 270 to 280px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			text is "Visit Date"
			
		value-visit-date:
			inside div-container 270 to 280px top
			#css font-family contains "Helvetica Neue, Helvetica, Arial, sans-serif"
			near lbl-visit-date 190 to 200px right
			
		btn-homepage:
			inside div-container 55 to 65px bottom