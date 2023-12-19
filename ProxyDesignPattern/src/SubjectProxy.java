import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
class SubjectProxy implements InvocationHandler {
    private final Subject realSubject;
    public SubjectProxy(Subject realSubject) {
        this.realSubject = realSubject;
    }
    public Object getProxy() {
        return Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("SubjectProxy: do something before the real subject's action is called.");
        method.invoke(realSubject, args);
        System.out.println("SubjectProxy: do something after the real subject's action is called.");
        return null;
    }
}