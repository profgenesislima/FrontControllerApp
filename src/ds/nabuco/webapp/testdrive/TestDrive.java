package ds.nabuco.webapp.testdrive;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import d.webapp.model.Client;



public class TestDrive{

	public static void main(String[]args){
		Class clazz=Client.class;
		
		System.out.println("ClassName:"+clazz.getName());
		System.out.println("ClassSimpleName:"+clazz.getSimpleName());
		
		int modifiers =clazz.getModifiers();
		
		System.out.println(Modifier.isAbstract(modifiers));
		System.out.println(Modifier.isFinal(modifiers));
		System.out.println(Modifier.isInterface(modifiers));	
		System.out.println(Modifier.isNative(modifiers));
		System.out.println(Modifier.isPrivate(modifiers));
		System.out.println(Modifier.isProtected(modifiers));
		System.out.println("PUBLIC ? "+Modifier.isPublic(modifiers));
		System.out.println(Modifier.isStatic(modifiers));
		System.out.println(Modifier.isStrict(modifiers));
		System.out.println(Modifier.isSynchronized(modifiers));
		System.out.println(Modifier.isTransient(modifiers));
		System.out.println(Modifier.isVolatile(modifiers));
		
		 Field[] fields = clazz.getFields();
		 Method[] methods = clazz.getMethods();
		 System.out.println("FIELD LENGTH: "+fields.length);
		 
		 for(Method method : methods){
			    if(isGetter(method)&& !method.getName().equals("getClass")) System.out.println("getter: " + method);
			    if(isSetter(method)) System.out.println("setter: " + method);
			  }
		 
		 System.out.println("METHOD LENGTH: "+methods.length);
		 try {
			try {
				Client cli = new Client();
				cli.setName("GENESIS");
				System.out.println("RUNNING METHOD: "+clazz.getMethod("getName", null).invoke(cli, null));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		 for(int i=0;methods.length>i;i++){
			 System.out.println("FIELD ->"+methods[i].getName());
			 
		 }
		 

           System.out.println("GET ATTRIBUTES "+ "getName".substring(3, "getName".length()));
		 
		 
	}
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
}
