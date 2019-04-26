package ds.nabuco.webapp.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

	
	public static boolean isGetter(Method method){
		  if(!method.getName().startsWith("get"))      return false;
		  if(method.getParameterTypes().length != 0)   return false;  
		  if(void.class.equals(method.getReturnType())) return false;
		  return true;
		}

		public static boolean isSetter(Method method){
		  if(!method.getName().startsWith("set")) return false;
		  if(method.getParameterTypes().length != 1) return false;
		  return true;
		}
		
		public static List<String> getAttributesAsString(Class clazz){
			 List<String> methods =new ArrayList<>();			 
			 for(Method method: clazz.getMethods()){
				 if(isGetter(method) && !method.getName().equals("getClass")){
					 methods.add(method.getName().substring(3, method.getName().length()));
				 }
					 
			 }
			
			return methods;
		}
		
		
}
