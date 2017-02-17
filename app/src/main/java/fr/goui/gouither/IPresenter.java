package fr.goui.gouither;

/**
 * Interface for the default presenter.
 */
public interface IPresenter<T> {

    void attachView(T view);

    void detachView();
}
