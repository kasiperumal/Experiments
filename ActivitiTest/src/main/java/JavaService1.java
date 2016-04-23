

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JavaService1 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		arg0.setVariable("result","1");

	}

}
