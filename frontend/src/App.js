import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./pages/header/Header";
import Dashboard from "./pages/header/Dashboard";
import { Routes, Route } from "react-router-dom";
import NoMatch from "./pages/nomatch/NoMatch";
import AddEducator from "./pages/educator/AddEducator";
import UpdateEducator from "./pages/educator/UpdateEducator";

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/educator" element={<AddEducator />} />
        <Route path="/educator/:id" element={<UpdateEducator />} />
        <Route path="*" element={<NoMatch />} />
      </Routes>
    </>
  );
}

export default App;
