package com.kylin.webcluster.hasingleton.service;

import org.jboss.as.clustering.singleton.SingletonService;
import org.jboss.as.server.ServerEnvironment;
import org.jboss.as.server.ServerEnvironmentService;
import org.jboss.logging.Logger;
import org.jboss.msc.service.DelegatingServiceContainer;
import org.jboss.msc.service.ServiceActivator;
import org.jboss.msc.service.ServiceActivatorContext;
import org.jboss.msc.service.ServiceController;

/**
 * Service activator that installs the HATimerService as a clustered singleton service during deployment.
 *
 */
public class HATimerServiceActivator implements ServiceActivator {
	
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public void activate(ServiceActivatorContext context) {
    	
        log.info("HATimerService will be installed!");

        HATimerService service = new HATimerService();
        SingletonService<String> singleton = new SingletonService<String>(service, HATimerService.SINGLETON_SERVICE_NAME);
        /*
         * We can pass a chain of election policies to the singleton, for example to tell JGroups to prefer running the singleton on a node with a
         * particular name
         */
        // singleton.setElectionPolicy(new PreferredSingletonElectionPolicy(new SimpleSingletonElectionPolicy(), new NamePreference("node2/cluster")));

        singleton.build(new DelegatingServiceContainer(context.getServiceTarget(), context.getServiceRegistry()))
                .addDependency(ServerEnvironmentService.SERVICE_NAME, ServerEnvironment.class, service.env)
                .setInitialMode(ServiceController.Mode.ACTIVE)
                .install()
        ;
    }
}
