create table ocorrencia (
	id bigserial primary key,
	entrega_id bigint not null,
	descricao text not null,
	data_registro timestamp not null
);

alter table ocorrencia add constraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega(id);