⭐ Recommendation Service
Base URL: https://recommendationservice-rlr1.onrender.com/api/v1/recommendations

🔹 Get All Recommendations
GET /recommendations/

🔹 Get Recommendation by ID
GET /recommendations/{bookId}

🔹 Delete Recommendation by ID
DELETE /recommendations/{bookId}

🔹 Create a Recommendation
POST /recommendations

Request Body:

json
Copy code
{
  "bookId": "book_id_here",
  "author": "Recommender",
  "rate": 4.5,
  "content": "Highly recommended for beginners!"
}
🔹 Update a Recommendation
PUT /recommendations/{bookId}

Request Body:

json
Copy code
{
  "bookId": "book_id_here",
  "author": "Updated Author",
  "rate": 4.0,
  "content": "Updated content here."
}
