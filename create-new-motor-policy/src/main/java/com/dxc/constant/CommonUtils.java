package com.dxc.constant;

/**
 * 
 * @author hnguyen399
 *
 */
public class CommonUtils {

	public enum STATUS_MOTOR {
		Pending("1"),
		In_force("2");
		
		public String value;
		
		public String getValue() {
			return this.value;
		}

	    private STATUS_MOTOR(String value) {
	        this.value = value;
	    } 
	}
}
