import { Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import AgentDashboard from "./pages/AgentDashboard";
import ContractorDashboard from "./pages/ContractorDashboard";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/agent" element={<AgentDashboard />} />
      <Route path="/contractor" element={<ContractorDashboard />} />
    </Routes>
  );
}

export default App;
