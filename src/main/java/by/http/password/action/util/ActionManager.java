package by.http.password.action.util;

import by.http.password.action.BaseAction;
import by.http.password.action.impl.CheckLoginImpl;
import by.http.password.action.impl.CreateBookImpl;
import by.http.password.action.impl.DeleteBookImpl;
import by.http.password.action.impl.LookLibraryImlp;
import by.http.password.action.impl.PreparingBookCreateImpl;
import by.http.password.action.impl.PreparingBookUpdateImpl;
import by.http.password.action.impl.RegistrationImpl;
import by.http.password.action.impl.UpdateBookImpl;

public class ActionManager {
	
	public static BaseAction determineAction(String action) {
		BaseAction act = null;
		
		switch (action){
			case "loginForm":
				act = new CheckLoginImpl();
				break;
			case "lookLib":
				act = new LookLibraryImlp();
				break;
			case "delete_book":
				act = new DeleteBookImpl();
				break;
			case "update_book":
				act = new PreparingBookUpdateImpl();
				break;
			case "create_book":
				act = new PreparingBookCreateImpl();
				break;
			case "createBook":
				act = new CreateBookImpl();
				break;
			case "updateBook":
				act = new UpdateBookImpl();
				break;
			case "registerForm":
				act = new RegistrationImpl();
				break;
		}
		return act;
	}
}
