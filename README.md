# jboss-6-default

Sample webapps to run on a stock JBoss 6. These were created while working on a legacy system... Working after 8 years deprecation.

In case getting these exceptions at boot:

> WARN  [AbstractKernelController] Broken callback: ClassSingleCallbackItem@52edb54d{name=interface org.jboss.wsf.spi.metadata.DescriptorProcessor whenRequired=ControllerState@1a3dae70{Installed} dependentState=ControllerState@1a3dae70{Installed} attributeName=setProcessor owner=AbstractKernelControllerContext@395e6c9e{ metadata=AbstractBeanMetaData@5621a1c1{name=JMSDescriptorDeployer bean=org.jboss.webservices.integration.deployers.JMSDescriptorDeployer properties= classLoader=BeanMetaDataDeployer$DeploymentClassLoaderMetaData@1119de7f{classloader=null} constructor=null autowireCandidate=true installCallbacks=[method=setProcessor, method=setParser]}name=JMSDescriptorDeployer target=org.jboss.webservices.integration.deployers.JMSDescriptorDeployer@7419fcc3 state=Installed depends=AbstractDependencyInfo@3a02b214{}} signature=org.jboss.wsf.spi.metadata.DescriptorProcessor}: java.lang.ClassCastException: org.jboss.wsf.framework.deployment.jms.WebservicesDescriptorProcessorImpl cannot be cast to org.jboss.wsf.spi.metadata.jms.JMSDescriptorProcessor
    ...
> WARN  [AbstractKernelController] Broken callback: ClassSingleCallbackItem@37e497b2{name=interface org.jboss.wsf.spi.metadata.DescriptorProcessor whenRequired=ControllerState@1a3dae70{Installed} dependentState=ControllerState@1a3dae70{Installed} attributeName=setProcessor owner=AbstractKernelControllerContext@5cca1618{ metadata=AbstractBeanMetaData@69058404{name=WSDescriptorDeployer bean=org.jboss.webservices.integration.deployers.WSDescriptorDeployer properties= classLoader=BeanMetaDataDeployer$DeploymentClassLoaderMetaData@b27b8a0{classloader=null} constructor=null autowireCandidate=true installCallbacks=[method=setProcessor, method=setParser]}name=WSDescriptorDeployer target=org.jboss.webservices.integration.deployers.WSDescriptorDeployer@5eb74172 state=Installed depends=AbstractDependencyInfo@691e5879{}} signature=org.jboss.wsf.spi.metadata.DescriptorProcessor}: java.lang.ClassCastException: org.jboss.wsf.stack.cxf.deployment.jms.JMSDescriptorProcessorImpl cannot be cast to org.jboss.wsf.spi.metadata.webservices.WebservicesDescriptorProcessor

Can be solved modifying stack-agnostic-jboss-beans.xml, commenting the
setProcessor node and adding a property:

  &lt;!-- deployers --&gt;
  &lt;bean name="WSDescriptorDeployer" class="org.jboss.webservices.integration.deployers.WSDescriptorDeployer"&gt;
    &lt;!-- &lt;incallback method="setProcessor"/&gt; --&gt;
    &lt;property name="processor"&gt;
        &lt;inject bean="WSDescriptorProcessor"/&gt;
    &lt;/property&gt;
    &lt;incallback method="setParser"/&gt;
  &lt;/bean&gt;

  &lt;bean name="JMSDescriptorDeployer" class="org.jboss.webservices.integration.deployers.JMSDescriptorDeployer"&gt;
       &lt;!-- &lt;incallback method="setProcessor"/&gt; --&gt;
    &lt;property name="processor"&gt;
        &lt;inject bean="CXFJMSDescriptorProcessor"/&gt;
    &lt;/property&gt;
    &lt;incallback method="setParser"/&gt;
  &lt;/bean&gt;
