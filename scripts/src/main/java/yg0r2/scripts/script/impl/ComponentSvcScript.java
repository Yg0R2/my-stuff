package yg0r2.scripts.script.impl;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;

public class ComponentSvcScript implements Script {

    @Override
    public void execute(Args args) throws ScriptException {
        //mvn clean install

        //mvn -f web/pom.xml tomcat7:run -Dheader.server.assets.url=ssl.dev-hotels.com/assets //RUN

        //...bookingapp-web\src\main\resources\conf\environment\env_rules_development.properties
        //HEADER_SERVICE_URL=http://localhost:61535/component_svc
    }

    @Override
    public void printUsage() {

    }

}
