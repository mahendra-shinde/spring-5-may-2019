Request Mapping

Request Typ | Using Old Request Mapping | Using new Annotations
------------|---------------------------|-----------------------
GET	    |@RequestMapping("/find")  	| @GetMapping("/find")
POST	    |@RequestMapping(value="/save", method=RequestMethod.POST) | @PostMapping("/save")
PUT	    |@RequestMapping(value="/update",method=RequestMethod.PUT)  | @PutMapping("/update")
DELETE	    |@RequestMapping(value="/delete",method=RequestMethod.DELETE) | @DeleteMapping("/delete");
PATCH	    | @RequestMapping(value="/patch", method=RequestMapping.PATCH) | @PatchMapping("/patch")

 > New annotations were available from spring 4 onwards.

