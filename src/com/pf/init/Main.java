package com.pf.init;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import com.pf.mvc.controllers.ControllerPrincipal;
import com.pf.mvc.views.ViewPrincipal;

public class Main {

	public static void main(String[] args) {
		
		//FlatGradiantoDeepOceanIJTheme.install();
		
		new ControllerPrincipal().init();
		
	}

}
