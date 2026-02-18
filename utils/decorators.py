import functools

def log_test(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        print(f"\nSTARTING TEST: {func.__name__}")
        func(*args, **kwargs)
        print(f"ENDING TEST: {func.__name__}")
    return wrapper
