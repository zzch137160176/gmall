package per.zzch.gmall.admin.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import per.zzch.gmall.to.CommonResult;

@Aspect     // aop注解
@Component
public class DataValidAspect {

    /**
     * 检测传参是否符合要求
     * 环绕通知
     * admin包下 任意多层包下 任意以Controller结尾的类 任意方法 带任意参数
     *
     * @param point
     * @return
     */
    @Around("execution(* per.zzch.gmall.admin..*Controller.*(..))")
    public Object validAround(ProceedingJoinPoint point) {

        Object proceed = null;

        try {
            // 执行前置通知

            Object[] args = point.getArgs();

            for (Object obj:args) {
                if (obj instanceof BindingResult) {
                    BindingResult result = (BindingResult) obj;
                    if (result.getErrorCount() > 0) {
                        // 自动校验检测到错误
                        return new CommonResult().validateFailed(result);
                    }
                }
            }

            // 执行返回通知
            // 相当于method.invoke
            proceed = point.proceed(args);
        }catch (Throwable throwable) {
            // 执行异常通知
            throw new RuntimeException(throwable);
        } finally {
            // 执行后置通知
        }

        return proceed;
    }

}
