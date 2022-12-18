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
import TerminiID from "../Termini/TerminiID";
import DodajTermin from "../Termini/DodajTermin";
import Aktivnosti from "../Aktivnosti/Aktivnosti";
import AktivnostiID from "../Aktivnosti/AktivnostiID";
import DodajAktivnost from "../Aktivnosti/DodajAktivnost";
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
      <Route path="/termini/dodaj" element={<DodajTermin />} />
      <Route path="/termini/:IdTermin" element={<TerminiID />} />
      <Route path="/aktivnosti" element={<Aktivnosti />} />
      <Route path="/aktivnosti/dodaj" element={<DodajAktivnost />} />
      <Route path="/aktivnosti/:IdAktivnost" element={<AktivnostiID />} />
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}
