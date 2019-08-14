package com.pib.property.log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class DebugSetting {
	public static boolean debug = true;//可考虑设置为-1: notSet, 0: off, 1: on 
	
	@Value( "${core.debug:false}" )
	public boolean debugMode;
	
	public boolean getDebugMode() {
		return this.debugMode;
	}
}
