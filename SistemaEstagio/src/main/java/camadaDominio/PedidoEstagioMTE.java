package camadaDominio;

public class PedidoEstagioMTE {
	public static SituacaoDiscente verificarSituacaoDiscente(float IRA, int cargaHoraria) {
		int minimoCreditos = 80;
		if (cargaHoraria < minimoCreditos) {
			return SituacaoDiscente.CARGA_HORARIA_INVALIDA;
		}
		if (IRA >= 6.0) {
			return SituacaoDiscente.IRA_INVALIDO;
		}
		return SituacaoDiscente.APROVADO;
	}
	
	public static boolean verificaIntencaoEstagio(String nome, String matricula, 
			float IRA, int cargaHorariaCumprida, String endereco, boolean primeiroEstagio, 
			String nomeEmpresa, String enderecoEmpresa, String modalidadeEstagio, 
			int cargaHorariaSemanal, float valorBolsa, String resumo, String relacaoConteudo, String motivoEstagio) {
		if (cargaHorariaSemanal > 30) {
			return false;
		}
		return !nome.isBlank() && !matricula.isBlank() && !endereco.isBlank() && !nomeEmpresa.isBlank()
				&& !enderecoEmpresa.isBlank() && !modalidadeEstagio.isBlank() && !resumo.isBlank()
				&& !relacaoConteudo.isBlank() && !motivoEstagio.isBlank() && IRA > 0 && cargaHorariaCumprida > 0
				&& cargaHorariaSemanal > 0 && valorBolsa > 0;
	}
}
