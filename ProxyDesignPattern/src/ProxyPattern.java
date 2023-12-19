public class ProxyPattern{
    public static void main(String[] args) {
        Mobile realSubject = new Mobile();
        Subject proxy = (Subject) new SubjectProxy(realSubject).getProxy();
        proxy.action();
    }
}