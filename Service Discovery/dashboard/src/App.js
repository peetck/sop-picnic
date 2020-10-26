import "./App.css";
import { useState, useEffect } from "react";
import { Container, Table } from "react-bootstrap";
import axios from "axios";

function App() {
  const [services, setServices] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      console.log("FETCH");
      try {
        const response = await axios("http://localhost:8761/eureka/apps");
        const arr = [];

        for (let service of response.data.applications.application) {
          const data = {
            name: service.name,
            status: service.instance[0].status,
            instanceId: service.instance[0].instanceId,
          };
          arr.push(data);
        }

        const prevServices = [...services];
        for (let prevService of prevServices) {
          if (
            arr.findIndex((service) => service.name === prevService.name) === -1
          ) {
            arr.push({ ...prevService, status: "DOWN" });
          }
        }
        setServices(arr);
      } catch (err) {
        const prevServices = [...services];
        const arr = [];
        for (let prevService of prevServices) {
          arr.push({ ...prevService, status: "DOWN" });
        }
        setServices(arr);
      }
    };
    const timer = setInterval(() => fetchData(), 1000);
    return () => clearTimeout(timer);
  }, [services]);

  return (
    <Container className="mt-5">
      <h1>Dashboard</h1>
      <Table striped bordered hover>
        <thead className="text-center">
          <tr>
            <th>#</th>
            <th>Application</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {services.map((service, index) => {
            return (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{service.name}</td>
                <td>
                  <span
                    className={`font-weight-bold ${
                      service.status === "UP" ? "text-success" : "text-danger"
                    }`}
                  >
                    {service.status}
                  </span>{" "}
                  <span>{service.instanceId}</span>
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </Container>
  );
}

export default App;
