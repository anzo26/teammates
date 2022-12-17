import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import PageNotFound from "../PageNotFound/PageNotFound";
import Home from "../Home/Home";
import Uporabniki from "../Uporabniki/Uporabniki";
import UporabnikiID from "../Uporabniki/UporabnikiID";
import DodajUporabnika from "../Uporabniki/DodajUporabnika";
import Lokacije from "../Lokacije/Lokacije";
import LokacijeID from "../Lokacije/LokacijeID";
import DodajLokacijo from "../Lokacije/DodajLokacijo";
import Termini from "../Termini/Termini";
import Aktivnosti from "../Aktivnosti/Aktivnost";
import FiltriraneLokacije from "../Lokacije/FiltriraneLokacije";

export default function Routing() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/uporabniki" element={<Uporabniki />} />
      <Route path="/uporabniki/dodaj" element={<DodajUporabnika />} />
      <Route path="/uporabniki/:IdUporabnik" element={<UporabnikiID />} />
      <Route path="/lokacije" element={<Lokacije />} />
      <Route path="/lokacije/dodaj" element={<DodajLokacijo />} />
      <Route path="/lokacije/:IdLokacija" element={<LokacijeID />} />
      <Route
        path="/lokacije/:Pnaslov/:Pregija/:Pposta"
        element={<FiltriraneLokacije />}
      />
      <Route path="/termini" element={<Termini />} />
      <Route path="/aktivnosti" element={<Aktivnosti />} />
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}
