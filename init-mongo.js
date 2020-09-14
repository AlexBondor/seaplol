db.createUser({
		user: "seaplol",
		pwd: "seaplol",
		roles: [
			{
				role: "readWrite",
				db: "accounting"
			}
		]
	}
)