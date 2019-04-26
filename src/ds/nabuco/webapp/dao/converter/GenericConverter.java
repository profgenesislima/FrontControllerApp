package ds.nabuco.webapp.dao.converter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import ds.nabuco.webapp.model.Client;
import ds.nabuco.webapp.utils.ReflectionUtils;

public class GenericConverter {

	public static Map<String, String> toRedis(Client t) throws ReflectiveOperationException {
		Map<String,String> clientKV = new HashMap<>();
		 for(Method method: t.getClass().getMethods()){
			 if(ReflectionUtils.isGetter(method) && !method.getName().equals("getClass")){
				 clientKV.put(method.getName().substring(3, method.getName().length()),  String.valueOf(method.invoke(t, null)));
			 }
				 
		 }
		    
		
		return clientKV;
	}

	

		
		
}
