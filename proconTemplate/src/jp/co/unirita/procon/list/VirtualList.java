package jp.co.unirita.procon.list;

public interface VirtualList<T> {
	
	// ���X�g�S�̂̃T�C�Y��Ԃ�
	public long size();
	
	// ���X�g�̒��Œl���܂܂�Ă��鐔��Ԃ�
	public long count();
	
	// �w�肳�ꂽ�Y�����ŃA�N�Z�X�����l��Ԃ�
	public T get(long idx);
	
	// �w�肳�ꂽ�͈͂̒l��z��ŕԂ�
	public T[] get(long startIdx, long endIdx);
	
	// �w�肳�ꂽ�ʒu�ɒl���Z�b�g����
	public void set(long idx, T value);
	
	// �w�肳�ꂽ�͈͂ɒl���Z�b�g����
	public void set(long startIdx, long endIdx, T value);
	
	// �w�肳�ꂽ�Y�����ŃA�N�Z�X�����l���폜����
	public void remove(long idx);
	
	// �w�肳�ꂽ�͈͂̓Y�����ŃA�N�Z�X�����l���폜����
	public void remove(long startIdx, long endIdx);
}
