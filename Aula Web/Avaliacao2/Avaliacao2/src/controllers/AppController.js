import { useState } from 'react';
import { FuncionarioModel } from '../models/FuncionarioModel';

export function useAppController() {
  const [paginaAtual, setPaginaAtual] = useState('HOME');
  const funcionarios = FuncionarioModel.listarTodos();
  const usuarioLogado = FuncionarioModel.obterUsuarioLogado();

  const navegarPara = (pagina) => {
    setPaginaAtual(pagina);
  };

  return {
    paginaAtual,
    navegarPara,
    funcionarios,
    usuarioLogado
  };
}