import subprocess
import sys


def run_tests() -> int:
	result = subprocess.run(["mvn", "-q", "test"], check=False)
	return result.returncode


if __name__ == "__main__":
	exit_code = run_tests()
	if exit_code == 0:
		print("Tests passed")
	else:
		print("Tests failed")
	sys.exit(exit_code)
