@FunctionalInterface
public interface Provider<T>
{
	T get();
	
	public static <T> Provider<T> of(T value)
	{
		return () -> value;
	}
}
