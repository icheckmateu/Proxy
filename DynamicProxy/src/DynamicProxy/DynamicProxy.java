package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//Object proxy:������Ķ���
//Method method:Ҫ���õķ���
//Object[] args:��������ʱ����Ҫ����
public abstract class DynamicProxy implements InvocationHandler {
  //Ŀ�����
  private Object target;
  //�󶨹�ϵ��Ҳ���ǹ������ĸ��ӿڣ�������ʵ����󶨣�����Щ������������ʱ��ִ��invoke������
  public Object newProxyInstance(Object targetObject){
      this.target=targetObject;
      //�÷�������Ϊָ����װ������һ��ӿڼ����ô��������ɶ�̬������ʵ��
      //��һ������ָ�������������������������Ҫ����ָ��Ϊ��Ŀ�����ͬһ���������
      //�ڶ�������Ҫʵ�ֺ�Ŀ�����һ���Ľӿڣ�����ֻ��Ҫ�õ�Ŀ������ʵ�ֽӿ�
      //����������������Щ�����صķ����ڱ�����ʱ��Ҫִ���ĸ�InvocationHandler��invoke����
      //���ݴ����Ŀ�귵��һ���������
      return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
              targetObject.getClass().getInterfaces(),this);
  }
  @Override
  //���������ʵ����ķ���������ʱ����ִ��
  /*InvocationHandler�ӿڵķ�����proxy��ʾ����method��ʾԭ���󱻵��õķ�����args��ʾ�����Ĳ���*/
  public Object invoke(Object proxy, Method method, Object[] args)
          throws Throwable {
        //��ӡ����
//      for(int i=0;i<args.length;i++){
//          System.out.println(args[i]);
//      }
      Object ret=null;
      try{
          //����Ŀ�귽��
          ret=method.invoke(target, args);
      }catch(Exception e){
          e.printStackTrace();
          throw e;
      }
      return ret;
  }
}