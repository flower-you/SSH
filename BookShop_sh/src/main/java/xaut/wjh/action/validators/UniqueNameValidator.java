package xaut.wjh.action.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

import xaut.wjh.dao.IUserDao;
import xaut.wjh.util.DaoFactory;

public class UniqueNameValidator extends FieldValidatorSupport{
	
	private IUserDao userdao=DaoFactory.getUserDao();

	@Override
	public void validate(Object object) throws ValidationException {
		String fieldName=this.getFieldName();
		Object value=this.getFieldValue(fieldName, object);
		if(value!=null) {
			String username=value.toString();
			if(username.trim().length()>0) {
				try {
					boolean flag=userdao.existsName(username);
					if(flag) {
						this.addFieldError(fieldName,this.getDefaultMessage());
					}
					
				}
				catch(Exception e) {
					throw new ValidationException(e.getMessage());
				}
			}
		}
		
	}

	
}
