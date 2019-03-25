//package Losowanie;
//
//import com.sun.deploy.util.StringUtils;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.validator.FacesValidator;
//import javax.faces.validator.Validator;
//import javax.faces.validator.ValidatorException;
//
//@FacesValidator("PeselNameValidator")
//public class PeselValidator implements Validator {
//
//    private boolean isNumeric(String str) {
//        try {
//            Double.parseDouble(str);
//            return true;
//        } catch(NumberFormatException e){
//            return false;
//        }
//    }
//
//    public void validate(FacesContext context, UIComponent component,
//                         Object value) throws ValidatorException {
//
//        if(this.isNumeric(value.toString()) && value.toString().length() < 12){
//
//            FacesMessagxe msg =
//                    new FacesMessage("E-mail validation failed.",
//                            "Invalid E-mail format.");
//            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            throw new ValidatorException(msg);
//
//        }
//    }
//
//}
