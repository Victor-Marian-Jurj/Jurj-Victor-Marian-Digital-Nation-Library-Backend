Descriere API
---------------------------

books-controller

GET/books

POST/books

GET/books/{id}

DELETE/books/{id}

PATCH/books/{id}

----------------------------

CreateBookRequest{
isbn	string
authors	string
title	string
types	string
year	integer($int32)
description	string
}

UpdateBookRequest{
isbn	string
authors	string
title	string
types	string
year	integer($int32)
description	string
}

Book{
bookId	integer($int64)
isbn	string
authors	string
title	string
types	string
year	integer($int32)
description	string
}

BookDto{
bookId	integer($int64)
isbn	string
authors	string
title	string
types	string
year	integer($int32)
description	string
}

BookResponse{
book	[BookDto{
bookId	integer($int64)
isbn	string
authors	string
title	string
types	string
year	integer($int32)
description	string
}]
}
