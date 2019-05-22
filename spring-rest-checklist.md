# Checklist:

1. Do I have matching package names for Main class, controllers, services, dao's and entities?

2. Have I placed @Service annotations on All service implementation classes?

3. Have I placed @Repository annotation on
all DAO Implementation classes?

4. Have I placed @RestController annotation on all Controller classes?

5. Have I written correct Mapping annotation in each method inside controllers?

6. Use PathVariables:
	@GetMapping("/find/{id}")
	public Employee find(@PathVariable Integer id){ ... }

OR RequestParam:
	@GetMapping("/find")
	public Employee find(@RequestParam Integer id){ ... }

DON'T Mix them!