import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import PageNotFound from "../PageNotFound/PageNotFound";
import Home from "../Home/Home";
import Uporabniki from "../Uporabniki/Uporabniki";
import Lokacije from "../Lokacije/Lokacije";
import Termini from "../Termini/Termini";
import Aktivnosti from "../Aktivnosti/Aktivnost";

export default function Routing() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/uporabniki" element={<Uporabniki />} />
      <Route path="/lokacije" element={<Lokacije />} />
      <Route path="/termini" element={<Termini />} />
      <Route path="/aktivnosti" element={<Aktivnosti />} />
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}
