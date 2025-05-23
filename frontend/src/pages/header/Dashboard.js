import { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";

function Dashboard() {
  const [educators, setEducators] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    const fetchEducators = async () => {
      try {
        const response = await fetch("http://localhost:8080/educators");
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const data = await response.json();
        setEducators(data);
      } catch (error) {
        console.error("Error fetching educators:", error);
      }
    };
    fetchEducators();
  }, []);

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/Educator/${id}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      setEducators(educators.filter((educator) => educator.id !== id));
    } catch (error) {
      console.error("Error deleting educator:", error);
    }
  };

  const handleUpdate = (id) => {
    navigate(`/educator/${id}`);
  };

  return (
    <>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Email</th>
            <th scope="col">Sebject</th>
            <th scope="col">Activity</th>
          </tr>
        </thead>
        <tbody>
          {educators.map((educator) => (
            <tr key={educator.id}>
              <th scope="row">{educator.id}</th>
              <td>{educator.firstName}</td>
              <td>{educator.lastName}</td>
              <td>{educator.email}</td>
              <td>{educator.specialization}</td>
              <td>
                <button
                  type="button"
                  class="btn btn-primary"
                  onClick={() => handleUpdate(educator.id)}
                >
                  update
                </button>
                <button
                  type="button"
                  class="btn btn-danger"
                  onClick={() => handleDelete(educator.id)}
                >
                  delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
export default Dashboard;
